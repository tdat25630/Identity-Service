package spring_learn.demo.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import spring_learn.demo.dto.response.PageResponse;

import java.util.List;
import java.util.function.Function;


@Mapper(componentModel = "spring")
public interface PageMapper {
    default <T, R> PageResponse<R> toPageResponse(
            Page<T> page,
            Function<T, R> mapper
    ) {
        List<R> items = page.getContent()
                .stream()
                .map(mapper)
                .toList();

        return PageResponse.<R>builder()
                .items(items)
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }
}
